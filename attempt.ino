#include <LiquidCrystal.h>


LiquidCrystal lcd(12, 11, 5, 4, 3, 2);

const int trigpin = 8;

const int echopin = 7;

long duration;

long distance1 ;

void setup()

{

pinMode(trigpin,OUTPUT);

pinMode(echopin,INPUT);

Serial.begin(9600);

}

void loop()

{

digitalWrite(trigpin,HIGH);

digitalWrite(trigpin,LOW);

duration=pulseIn(echopin,HIGH);

distance1=(duration/2)/29.1;

{ Serial.print("distance :");

Serial.println(distance1 );

delay(1000);

}

// include the library code:

// initialize the library with the numbers of the interface pins

// set up the LCD's number of columns and rows:

lcd.begin(16, 2); // Print a message to the LCD.

lcd.setCursor(0,0);

lcd.print("Current distance"); // Print a message to the LCD.

lcd.setCursor(1,1);

lcd.print(distance1);
lcd.print("cm");

}
