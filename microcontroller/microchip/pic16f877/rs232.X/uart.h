/* 
 * File:   uart.h
 * Author: hiram
 *
 * Created on December 14, 2014, 8:26 PM
 */

#ifndef UART_H
#define	UART_H

#ifdef	__cplusplus
extern "C" {
#endif

char UART_Init(const long int baudrate, const long int xtal_freq);
void UART_Write(char data);
char UART_TX_Empty();
void UART_Write_Text(char *text);
char UART_Data_Ready();
char UART_Read();
void UART_Read_Text(char *Output, unsigned int length);

#ifdef	__cplusplus
}
#endif

#endif	/* UART_H */

