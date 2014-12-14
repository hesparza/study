/* 
 * File:   led.c
 * Author: generic
 *
 * Created on November 27, 2014, 5:55 PM
 */

#include <stdio.h>
#include <stdlib.h>
#include <xc.h>

#define _XTAL_FREQ 20000000

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

int main()
{
  TRISB0 = 0; //RB0 as Output PIN
  while(1)
  {
    RB0 = 1;  // LED ON
    __delay_ms(1000); // 1 Second Delay
    RB0 = 0;  // LED OFF
    __delay_ms(1000); // 1 Second Delay
  }
  return 0;
}

