String Calculator
=================

A classic learning-TDD problem, the string calculator is a very simple number cruncher that takes strings of numbers
and performs basic calculations.

For this exercise, try not to read ahead through the steps: do them one at a time, treating them as new requirements
that are coming in one after the other from your PM.

Assumptions
-----------

* Input is valid: you don't need to handle bogus input values (except where stated)


Requirements
------------

h5. Simple addition

Write a method, `add(String numbers)`, that takes a list of either zero, one, or two numbers and adds them together.
Numbers are separated by commas.
Only the natural numbers (integers >= 0) are supported.
The empty string has a sum of 0.

h5. Adding arbitrary number of input values

Allow the `add` method to take a string with an unknown number of numbers.