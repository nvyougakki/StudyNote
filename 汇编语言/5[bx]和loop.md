### [bx]的意义

[bx]表示寄存器bx的值

例如mov ax,[bx]；将内存中ds:[bx]中的一个字内容赋值给ax

### loop

循环示例，循环计算2的12次方

```assembly
assume cs:code
code segment
	mov ax,2
	mov cx,11
  s:add ax,ax
  	loop s
  	mov ax,4c00h
  	int 21h
code ends
end		
```

当循环次数太多，可使用g <ip>命令跳过循环

![1571379362883](pic\1571379362883.png)

**段前缀**

mov ds:[bx],ax中，ds叫做段前缀

mov ds:[bx],ax  该指令可以直接将数据写入内存中，但是这么做是不安全的，因为内存中可能含有系统运行必要的数据，如果覆盖将会导致系统出错

0:200 -- 0:2ff这256个字节是安全的

段前缀的使用：将ffff:0 -- ffff:b的数据复制到0200:0 -- 0200assembly

```assembly
assume cs:code
	code segment
		mov bx,0
		mov cx,12
		s:mov ax,0ffffh
		mov ds,ax
		mov dl,[bx]
		
		mov ax,0020h
		mov ds,ax
		mov [bx],dl
		
		inc bx
		
		loop s
		
		mov ax,4c00h
		int 21h
	code ends
end
```



改进

```assembly
assume cs:code
	code segment
		mov ax,0ffffh
		mov ds,ax
		
		mov ax,0020h
		mov es,ax
		
		mov cx,12
		mov dx,0
		mov bx,0
		s: mov dl,bx
		mov es:[bx],dl
		inc bx
		
		mov ax,4c00h
		int 21h
	code ends
end
```

#### 练习

1. 向0:200 -- 0:23f写入0-63

   ```assembly
   assume cs:code
   	code segment
   		mov ax,0020h
   		mov ds,ax
   		mov bx,0
   		mov cx,64
   		s:mov [bx],bl
   		inc bx
   		loop s
   		mov ax,4c00h
   		int 21h
   	code ends
   end
   ```

2. 将mov ax,4c00h之前的指令复制到0:200处

   ```assembly
   assume cs:code
   	code segment
   		mov ax,cs
   		mov ds,ax
   		
   		mov ax,0200h
   		mov es,ax
   		mov bx,0
   		mov cx,0017h
   		s:mov al,[bx]
   		mov es:[bx],al
   		inc cx
   		loop s
   		mov ax,4c00h
   		int 21h
   	code ends
   end
   ```
