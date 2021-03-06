package main

import (
	"fmt"
	"math/rand"
)

type Job struct {
	Id        int
	RandomNum int
}

type Result struct {
	job *Job
	sum int
}

func main() {
	// demo1
	/*ch := make(chan int, 1)
	go recv(ch)
	ch <- 10
	//time.Sleep(time.Second)
	fmt.Println("发送成功")*/

	//demo2
	/*c := make(chan int)
	go func() {
		for i := 0; i < 5; i++{
			c <- i
		}
		close(c)
	}()
	for {
		if data, ok := <-c; ok {
			fmt.Println(data)
		} else {
			break
		}
	}

	fmt.Println("main end")*/

	//demo3

	/*ch1 := make(chan int)
	ch2 := make(chan int)

	go func() {
		for i := 0; i < 5; i++ {
			ch1 <- i
		}
		close(ch1)
	}()

	go func() {
		for {
			i, ok := <- ch1
			//time.Sleep(time.Second)
			if !ok {
				break
			}
			ch2 <- i * i
		}
		close(ch2)

	}()

	for i := range ch2 {
		fmt.Println(i)
	}*/

	//demo4
	/*ch1 := make(chan int)
	ch2 := make(chan int)
	go counter(ch1)
	go squarer(ch2, ch1)
	printer(ch2)*/

	jobChan := make(chan *Job, 128)
	resultChan := make(chan *Result, 128)

	createPool(64, jobChan, resultChan)

	go func(resultChan chan *Result) {
		for result := range resultChan {
			fmt.Printf("job id:%v randnum:%v result:%d\n", result.job.Id,
				result.job.RandomNum, result.sum)
		}
	}(resultChan)

	var id int
	for {
		id++
		r_num := rand.Int()
		job := &Job{
			Id:        id,
			RandomNum: r_num,
		}
		jobChan <- job
	}

}

func createPool(num int, jobChan chan *Job, resultChan chan *Result) {
	for i := 0; i < num; i++ {
		go func(jobChan chan *Job, resultChan chan *Result) {
			for job := range jobChan {
				r_num := job.RandomNum

				var sum int
				for r_num != 0 {
					tmp := r_num % 10
					sum += tmp
					r_num /= 10
				}

				r := &Result{
					job: job,
					sum: sum,
				}
				resultChan <- r
			}
		}(jobChan, resultChan)
	}
}

func recv(c chan int) {
	x := <-c

	fmt.Println("接收成功", x)
}

func counter(out chan<- int) {
	for i := 0; i < 5; i++ {
		out <- i
	}
	close(out)
}

func squarer(out chan<- int, in <-chan int) {
	for i := range in {
		out <- i * i
	}
	close(out)
}

func printer(i <-chan int) {
	for i := range i {
		fmt.Println(i)
	}
}
