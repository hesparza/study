/* 
 * File:   main.c
 * Author: hiram
 *
 * Created on January 8, 2015, 12:12 AM
 */

#include <stdio.h>
#include <stdlib.h>
#include <pic.h>
#include <pic16f877.h>

#define _XTAL_FREQ 20000000
#define WIEGAND_LENGTH 26

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

unsigned int DATA_LENGTH = 8;
char* dataIn;
unsigned char serialData;
unsigned char data[WIEGAND_LENGTH];
unsigned int i = 0;
int sendFlg = 0;


void interrupt catchInterrupts(void) {
    // Catch rs232 data available interrupt
    if (PIR1bits.RCIF == 1) {
        serialData = RCREG;
        TXREG = serialData;
        TXSTAbits.TXEN = 1;
        //while (PIR1bits.TXIF);
        //TXSTAbits.TXEN = 0;
        //UART_Read_Text(dataIn,DATA_LENGTH);
        //UART_Write_Text(dataIn);
        RB1 = 1;
        __delay_ms(10);
    }
}

void setupInterrupRoutines(void) {
    ei(); //Enable interrupt subroutines
    INTCONbits.PEIE = 1; //--\
                         //---> Enable Serial port interrupts
    PIE1bits.RCIE = 1;   //--/
    //INTCONbits.RBIE = 1;    //Enable port B RB7:RB4 interrupts
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
    //setupInterrupRoutines();
    portBConfiguration();

    while(1) {
    RB0 = 0;  // LED OFF
        if ((RB4 == 0 || RB5 == 0) && i == 0)
        {
            while(i < WIEGAND_LENGTH)                         //repeat the loop until all 26 bit data are sent (start from 0 to 25)
            {
                if((RB4==0)&&(RB5==1))          //if RB4 changes (RB4 is active low)
                {
                    data[i]=0;                  //save that the bit received is 0
                    while((RB4==0)&&(RB5==1)){RB0 = 1;}  //wait for data stream finish sending from RFID tag again (RB4 or RB5 will back to high logic)
                    i++;
                }
                else if ((RB4==1)&&(RB5==0))    //if RB5 received is 0 (RB5 is active low)
                {
                    data[i]=1;                  //save that the bit received is 1
                    while((RB4==1)&&(RB5==0)){RB0 = 1;}  //wait for data stream finish sending from RFID tag again (RB4 or RB5 will back to high logic)
                    i++;
                }
            }
            RB0 = 0;
        }

        if (i == WIEGAND_LENGTH) {
            i = 0;

            for (int x = 0; x < WIEGAND_LENGTH; x++) {
                if (data[x] == 1) {
                    TXREG = 49;
                } else if (data[x] == 0) {
                    TXREG = 48;
                }
                TXSTAbits.TXEN = 1;
                __delay_ms(10);
            }
            TXREG = 10;
            TXSTAbits.TXEN = 1;
            __delay_ms(10);
            TXREG = 13;
            TXSTAbits.TXEN = 1;
            __delay_ms(10);
        }
    }
    return 0;
}

