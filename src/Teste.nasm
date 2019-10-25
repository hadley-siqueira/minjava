; Teste.nasm

; c runtime
extern _alloc, _new_array, _print_int, _print_str


; vt definitions
segment .data
 Fac@@vt         : dd Fac@ComputeFac
 Factorial@@vt   : dd Factorial@main


; constructors
segment .text

 Fac@@new:
   push dword 4
   call _alloc
   add esp, 4
   mov [eax+0], dword Fac@@vt
   ret

 Factorial@@new:
   push dword 4
   call _alloc
   add esp, 4
   mov [eax+0], dword Factorial@@vt
   ret


; code
segment .text
 global _asmMain

 Fac@ComputeFac:
   push ebp
   mov ebp, esp
   sub esp, 20

   mov ebx, [ebp+8]
   cmp ebx, dword 1
   jge .if_false

   mov ebx, dword 1
   mov [ebp-12], ebx
   jmp .if_next

 .if_false:
   push edx
   mov ebx, [ebp+8]
   mov ecx, ebx
   sub ecx, dword 1
   push ecx
   mov edx, edx
   mov esi, [edx]
   call [esi+0]
   add esp, 4
   pop edx
   mov ebx, [ebp+8]
   mov ecx, ebx
   imul ecx, eax
   mov [ebp-12], ecx

 .if_next:
   mov ebx, [ebp-12]
   mov eax, ebx
   mov esp, ebp
   pop ebp
   ret


 _asmMain:
 Factorial@main:
   push ebp
   mov ebp, esp
   sub esp, 16

   push edx
   call Fac@@new
   pop edx
   push edx
   push dword 10
   mov edx, eax
   mov esi, [edx]
   call [esi+0]
   add esp, 4
   pop edx
   push edx
   push eax
   call _print_int
   add esp, 4
   pop edx

   mov esp, ebp
   pop ebp
   ret


