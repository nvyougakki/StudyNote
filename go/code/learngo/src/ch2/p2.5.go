//类型声明

package main

import (
	"fmt"
)

type Celsius float64
type Fahrenheit float64

func (c Celsius) String() string {
	return fmt.Sprintf("%g°C", c)
}

const (
	absoulteZeroC Celsius = -273.51
	FreezingC     Celsius = 0
	BollingC      Celsius = 100
)

func main() {
	fmt.Println(CToF(BollingC))

	fmt.Println(float64(FreezingC))
	//fmt.Println(FToC(0))
}

func CToF(c Celsius) Fahrenheit {
	return Fahrenheit(c * 9 / 5 + 32)
}

func FToC(f Fahrenheit) Celsius {
	return Celsius((f - 32) * 5 / 9)
}
