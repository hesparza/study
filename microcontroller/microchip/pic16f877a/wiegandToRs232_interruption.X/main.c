/*
 * File:   main.c
 * Author: hiram
 *
 * Created on March 31, 2015, 8:10 PM
 */

#include <xc.h>
#include <pic.h>

#define _XTAL_FREQ 20000000
#define WIEGAND_LENGTH 26
#define BITS_TO_SEND 32
#define BYTE_SIZE 8

// BEGIN CONFIG
#pragma config FOSC = HS // Oscillator Selection bits (HS oscillator)
#pragma config WDTE = ON // Watchdog Timer Enable bit (WDT enabled)
#pragma config PWRTE = OFF // Power-up Timer Enable bit (PWRT disabled)
#pragma config BOREN = ON // Brown-out Reset Enable bit (BOR enabled)
#pragma config LVP = OFF // Low-Voltage (Single-Supply) In-Circuit Serial Programming Enable bit (RB3 is digital I/O, HV on MCLR must be used for programming)
#pragma config CPD = OFF // Data EEPROM Memory Code Protection bit (Data EEPROM code protection off)
#pragma config WRT = OFF // Flash Program Memory Write Enable bits (Write protection off; all program memory may be written to by EECON control)
#pragma config CP = OFF // Flash Program Memory Code Protection bit (Code protection off)
//END CONFIG

//Global variables
unsigned char serialData;
unsigned char data[WIEGAND_LENGTH];
unsigned int i = 0;

//prototypes
void UART_Write(unsigned char data);

void interrupt catchInterrupts(void) {
    // Catch port B bits RB4 and RB5 interrupt
    if (INTCONbits.RBIF == 1 && i < WIEGAND_LENGTH) {
        if((RB4==0)&&(RB5==1))          //if RB4 changes (RB4 is active low)
        {
            data[i]=0;                  //save that the bit received is 0
            while((RB4==0)&&(RB5==1)){RB0 = 1;}  //wait for data stream finish sending from RFID tag again (RB4 or RB5 will back to high logic)
            i++;
            RB0 = 0;
            INTCONbits.RBIF = 0; //Clear interruption
        }
        else if ((RB4==1)&&(RB5==0))    //if RB5 received is 0 (RB5 is active low)
        {
            data[i]=1;                  //save that the bit received is 1
            while((RB4==1)&&(RB5==0)){RB0 = 1;}  //wait for data stream finish sending from RFID tag again (RB4 or RB5 will back to high logic)
            i++;
            RB0 = 0;
            INTCONbits.RBIF = 0; //Clear interruption
        }
    }
}

void setupInterrupRoutines(void) {
    ei(); //Enable interrupt subroutines
    INTCONbits.PEIE = 0; //--\
                         //---> Enable Serial port interrupts
    PIE1bits.RCIE = 0;   //--/
    INTCONbits.RBIE = 1;    //Enable port B RB7:RB4 interrupts
}

void UART_Initialization(void) {
    BRGH = 1;
    SPBRG = 64;                                   //Writing SPBRG Register
    SYNC = 0;                                     //Setting Asynchronous Mode, ie UART
    SPEN = 1;                                     //Enables Serial Port
    TRISC7 = 1;                                   //As Prescribed in Datasheet
    TRISC6 = 1;                                   //As Prescribed in Datasheet
    CREN = 1;                                     //Enables Continuous Reception
    TXEN = 1;                                     //Enables Transmission
}

void portBConfiguration(void) {
    TRISB = 0X30; //PINS RB4 and RB5 as Input, others as Output
    nRBPU = 0; //Setup internal weak pullup resistors on port B
}
/*
 *
 */
int main(int argc, char** argv) {
    UART_Initialization();
    setupInterrupRoutines();
    portBConfiguration();
    unsigned char dataToSend = 0b00000000;
    unsigned int counter = 8;
    while(1) {
        if (i == WIEGAND_LENGTH) {
            for (int x = 0; x < BITS_TO_SEND; x++) {
                if (counter > 0 && x < WIEGAND_LENGTH) {
                    dataToSend |= data[x] << (counter - 1);
                    counter--;
                } else if (counter > 0 && x >= WIEGAND_LENGTH) {
                    dataToSend |= 0 << (counter - 1);
                    counter--;
                }
                if (counter <= 0) {
                    UART_Write(dataToSend);
                    dataToSend = 0;
                    counter = 8;
                }
            }
            i = 0; //Clear i counter
        }
    }
}

void UART_Write(unsigned char data)
{
  while(!TRMT);  
  TXREG = data;
}