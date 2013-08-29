String Calculator
=================

A classic learning-TDD problem, the string calculator is a very simple number cruncher that takes strings of numbers
and performs basic calculations.

For this exercise, try not to read ahead through the steps: do them one at a time, treating them as new requirements
that are coming in one after the other from your PM.

Assumptions
-----------

* Input is valid: you don't need to handle bogus input values (except where stated)

Rules
-----

* No line of code (test or production) may be more than 7 lines long!
* You can write longer methods, but they must be made shorter in the refactor step: you cannot write a new failing test
  if you have any methods with > 7 lines.


Requirements
------------

#### Simple addition

* Write a method, `add(String numbers)`, that takes a list of either zero, one, or two numbers and adds them together.
* Numbers are separated by commas.
* Only the natural numbers (integers >= 0) are supported.
* The empty string has a sum of 0.

#### Adding arbitrary number of input values

* Allow the `add` method to take a string with an unknown number of numbers.

#### Formatting

* Allow the `add` method to optionally handle newlines between numbers instead of commas
    * the input "1,2\n3" is valid (you can mix commas and newlines)
    * the inputs "1,\n2" and "1,2\n" are invalid (either comma *or* newline, not both, and no trailing separator).
      You don't need to handle this case in your code.

#### Delimiters

* Allow for the specification of an arbitrary additional delimiter in your input
* To change the delimiter, a line can be optionally added to the start of the input in the form:

        //[delimiter]\n[numbers ...]

 For example, to change the delimiter to a semi-colon, the input would be:

        //;\n2;3;4

* The delimiter specification is optional.  In its absence, the existing rules should hold.  All of your existing
  tests should continue to pass.

#### Negative numbers

* Calling `add` with a negative number should throw an exception.
* The exception should include the negative number that was found
* If there is more than one negative number, all of them should be included in the exception message