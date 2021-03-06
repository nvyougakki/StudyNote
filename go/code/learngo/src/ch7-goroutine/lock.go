package main

import (
	"fmt"
	"sync"
	"sync/atomic"
	"time"
)

var x int64
var wg sync.WaitGroup
var lock sync.Mutex

var once sync.Once

var rwLock sync.RWMutex
func test() {
	for i := 0 ;i < 1000; i++ {
		lock.Lock()
		x = x + 1
		lock.Unlock()
	}
	wg.Done()
}

func write() {
	rwLock.Lock()
	x = x + 1
	time.Sleep(10 * time.Millisecond)
	rwLock.Unlock()
	wg.Done()

}

func read() {
	rwLock.RLock()
	time.Sleep(time.Millisecond)
	rwLock.RUnlock()
	wg.Done()
}

func main() {
	/*wg.Add(2)
	go test()
	go test()
	wg.Wait()
	fmt.Println(x)*/


	start := time.Now()
	for i := 0; i < 100000; i++ {
		wg.Add(1)
		//go atomicAdd()
		//go add()
		go mutexAdd()
	}
	/*for i := 0; i < 10; i++ {
		go write()
		wg.Add(1)
	}

	for i := 0; i < 1000; i++ {
		go read()
		wg.Add(1)
	}*/
	wg.Wait()
	end := time.Now()
	fmt.Println(x)
	fmt.Println(end.Sub(start))

}

func add() {
	x++
	wg.Done()
}

func mutexAdd() {
	lock.Lock()
	x++
	lock.Unlock()
	wg.Done()
}

func atomicAdd() {
	atomic.AddInt64(&x, 1)
	wg.Done()
}
