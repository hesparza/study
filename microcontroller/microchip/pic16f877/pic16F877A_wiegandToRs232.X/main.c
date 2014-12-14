/* 
 * File:   main.c
 * Author: hiram
 *
 * Created on November 23, 2014, 9:58 PM
 */

#include <stdio.h>
#include <stdlib.h>

#include "system.h" /* System funct/params, like osc/peripheral config */
#include <xc.h> /* Contains the definition of __delay_ms() function and TRIS, PORT registers */

#define _XTAL_FREQ 4000000
/*
 * 
 */
int main(int argc, char** argv) {

    ConfigureOscillator();

    /* Initialize I/O and Peripherals for application */
    InitApp();

    while (1) {
        RB0 = 1;  // LED ON
        __delay_ms(1000); // 1 Second Delay
        RB0 = 0;  // LED OFF
        __delay_ms(1000); // 1 Second Delay
    }
    
    return (EXIT_SUCCESS);
}

