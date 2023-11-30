### All questions given by Recruiter

---

# 1 
Recall that a "power of 2" is any integer of the form 2^n for integer n. 
Recall that the "median" of a list of numbers is defined as the "middle" of the sorted list of numbers. 
For example the median of [3, 1, 5, 7, 4] is 4. 

Design a data structure that supports the following operations: 
- A constructor, with no parameters. 
- `Insert(x)`, adds x to the data set, where x is an integer. 
- `LooseMedian()`, returns any integer within the nearest powers of 2 of the median of all inserted elements. 
- Nearest powers of 2 of the median m is defined as: 
  - If m is NOT a power of two, and we have 2<sup>k</sup> < m < 2<sup>(k+1)</sup>, then any integer in [2<sup>k</sup>, 2<sup>(k+1)]</sup> is acceptable. 
  - If m IS a power of two, i.e. m=2<sup>k</sup>, then any integer in [2<sup>(k-1)</sup>, 2<sup>(k+1)</sup>] is acceptable. 

Example: 
- Insert(3). Inserted elements are [3]. - LooseMedian(). Median is 3. Acceptable return values of are any of 2, 3, 4. 
- Insert(5). Inserted elements are [3, 5]. - Insert(4). Inserted elements are [3, 5, 4]. 
- LooseMedian(). Median is 4. Acceptable return values are any of 2, 3, 4, 5, 6, 7, 8. 

NOTE: Do give the example up front, as it quickly clarifies what "nearest powers of 2" means, which is necessary to understand the problem. 

*WARMUP QUESTION FOR L2/SWE INTERN* 
NB: I have found that candidates for roles junior to L3 FTE likely benefit from adding a warm-up question before the main question: 
# 1.1
Implement the BitWidth(x) function, which returns the number of bits required to represent a number, or the *bit width*. 

Examples: 
- BitWidth(5) == 3, 5 is represented as 0b101, or 3 bits. 
- BitWidth(1) == 1, 1 is represented as 0b1, or 1 bit.
- BitWidth(12) == 4, 12 is represented as 0b1100, or 4 bits. 

NB: If the candidate has very little knowledge of bits and bit-ops, 
we can also switch the problem to: 

# 1.2
Implement the GreatestPow2AtMost(x) function, which returns the largest power of 2 less than or equal to x. 

Examples: 
- BitWidth(5) == 4 
- BitWidth(1) == 1 
- BitWidth(12) == 8

---

# 2

A satellite image of the Pacific Ocean consists of green and blue pixels, representing land and water. The Pacific ocean is large, and mostly blue; but contains islands, which are green. Islands themselves may contain blue pixels, which are lakes.

A frontend presents the image to a user, who can click on it. 

When the user clicks on a green pixel, a popup will appear that displays the number of lakes on that island. This UI code already exists: the problem of this question is to write the backend function that will return the value to display.

As an example, consider an image (20 pixels wide by 8 tall) that is mostly blue; but contains 3 green rectangles:

- On the left of the image there is a horizontal line of three green pixels, from coordinates (2, 2) to (4, 2). This is an island with no lakes. In the middle is a 3x3 square of green pixels (coordinates (5, 4) to (7, 6)) where the center pixel (6, 5) is water. This is an island with 1 lake
- On the right is a green rectangle (coordinates (11, 3) to (16, 5)) where three internal pixels are water: (12, 4), (14, 4), and (15, 4). This forms an island with two lakes

Examples:

  - Add(2)
  - Add(3)
  - QueryNextSmallest() returns 2 (smallest element in {2, 3}) 
  - Add(1)
  - QueryNextSmallest() returns 2 (second smallest element in {1, 2, 3})
  - QueryNextSmallest() returns 3 (third-smallest element in {1, 2, 3}) and so on

---

# 3

A nephew found out that their uncle loves them so much, that they would do anything to buy them as many gifts as they possibly can. For this reason, the nephew prepares a list of gifts that they want and gives it to their uncle. 

Each item in the list contains 2 integers: 
- The day on which they want the gift (today is day 0), and the cost of it. 
- The uncle, knowing that their nephew is preparing such a list, saves $1 per day for the gifts, and initially (on day 0) they have $0. 

Calculate the maximum number of gifts the uncle can buy to their nephew.

---
# 4

You are the head chef for a new restaurant whose menu changes every night. You have a large book of recipes, and you select a different set of recipes each night. 

This is based on what you can make from the Raw Ingredients that you get each day. The ingredient for each recipe could be a raw ingredient or something you can make with other raw ingredients.

---
# 5

Let's define a kind of message called "Broadcast & Shut Down." When a router receives this message, it broadcasts the same message to all other routers within its wireless range. Then, that router shuts down, and can no longer send or receive messages.

For example: 
- Router A is at (0, 0); 
- Router B is at (0, 8); 
- Router C is at (0, 17); 
- Router D is at (11, 0). 
- If the wireless range is 10, when Router A sends a message, it could first reach B; the message from Router B would further reach Router C but Router D would never receive this message.

Given a list of routers' locations (their names and the corresponding 2D coordinates), tell me whether a message from Router A can reach Router B. Write a method / function with appropriate input and output arguments.

Assume:

- The names and coordinates of all routers are unique.
- Don't have to care about out-of-range numbers.
- Don't have to care about floating-point precision.

Follow-up question 1: nearest powered-on router (didn't have time to code it)

●	Initially, all the routers start as powered-on. Assume that a broadcast only transmits to the nearest powered-on router(s). If there are multiple powered-on router(s) that are at the same distance away from the transmitting router, all of them will receive the message and continue the broadcast chain.

---
# 6

You work as a consultant and have clients in city[A] and city[B]. 

On a given day, say i, you can either work in city[A] and make A[i] dollars or you can work in city[B] and make B[i] dollars. You can also spend the day traveling between city[A] and city[B] in which case your earnings that day are 0. 

Given A[1], A[2], …, A[n] and B[1], B[2], …, B[n], return a schedule S of N days which maximizes your earnings, where S is a string of length N, and S[i] = A/B/T where A means work in cityA, B means work in cityB, T means travel on day i. You can start either in cityA or cityB.

Example 1: A = [23, 4, 5, 10] and B = [21, 1, 10, 100] The optimal schedule S here would be -> "ATBB"

Example 2: A = [25,10,15,10,70] and B = [5,5,50,5,30] The optimal schedule S here would be -> "ATBTA"

---
# 7
