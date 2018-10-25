SIWEN YANG
s243yang@edu.uwaterloo.ca

I. INSTALL
------------
Javac SExpression.java
Java SExpression "(add 1 2)"


II. Design
----------
Use to stack to handle the order of operation and numbers.

Able to handle format like (add 1 2 3 (multiply 2 4))

With easy to add exp operation


III. ERROR HANDLING
-------------
return value is -1
Duplicate blank

return value is -2
Unknown operation

return value is -3
Operation spelling wrong

return value is -4
Wrong arguments
