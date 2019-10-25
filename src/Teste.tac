class Factorial:

procedure Factorial@main
   ; Block     : 0
   ; adj       : []
   ; write     : [.call, .new_Fac, .void]
   ; read      : [.call, .new_Fac]
   ; firstRead : []
   ; live      : []
   save_context;
   .new_Fac := call Fac@@new;
   load_context;
   save_context;
   param 10;
   param .new_Fac;
   .call := call Fac@ComputeFac;
   load_context;
   save_c_context;
   param .call;
   .void := call _print_int;
   load_c_context;
end
end

class Fac:

procedure Fac@ComputeFac
   ; Block     : 0
   ; adj       : [2, 1]
   ; write     : []
   ; read      : [num]
   ; firstRead : [num]
   ; live      : []
   if greater_or_equal(num, 1) goto .if_false;

   ; Block     : 1
   ; adj       : [3]
   ; write     : [num_aux]
   ; read      : []
   ; firstRead : []
   ; live      : [num_aux]
   num_aux := 1;
   goto .if_next;

   ; Block     : 2
   ; adj       : [3]
   ; write     : [.sub, .mult, .call, num_aux]
   ; read      : [.sub, .mult, num, .call]
   ; firstRead : [num]
   ; live      : [num_aux]
 .if_false:
   save_context;
   .sub := sub num, 1;
   param .sub;
   param this;
   .call := call Fac@ComputeFac;
   load_context;
   .mult := mult num, .call;
   num_aux := .mult;

   ; Block     : 3
   ; adj       : []
   ; write     : []
   ; read      : [num_aux]
   ; firstRead : [num_aux]
   ; live      : []
 .if_next:
   return num_aux;
end
end