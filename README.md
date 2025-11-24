# Functional Architecture
The project is constructed around several branches, starting with main, to demonstrate how one can create a functional 
architecture for it's program. Each building on the previous one, checkout all of them until "7-context-parameters" to 
follow up the code refactoring progression. 

## Main branch
We start with a usual problem : the `V400BankTerminal` class implements all the logic it needs in one single file. 
Maybe practical in the short term, but it comes with a very high cost : 
- It becomes way to big, SRP not applied.
- It has too many dependencies.
- It's nearly impossible to get a mental overview of what's going on.
- There's potentially a lot of known and unknown side effects.
- It's really difficult to maintain.

## 1. Delegating to classes
To follow the single responsibility principle, the first step we take is to delegate the implementation of each 
`BankTerminal` function to a dedicated class. Those dedicated classes become use cases.

### Advantages:
- Our code follows the SRP.
- `V400BankTerminal` has Fewer dependencies.
- It's possible to have an understanding of what's going on.
- It's possible to maintain.

### Disadvantages:
- The SRP is followed based on good will.
- The implementation in itself can still be too large.
- Nothing prevents apparition of side effects.
- With time, the same problem we had in `V400BankTerminal` could come back.

## 2. Delegating to functional interface
Since we only have one public function per delegate class, why not use a functional interface instead of a class?
Leverage operator functions on top of that, and we are now looking at functional programming.

### Advantages:
- The SRP is enforced.
- Lower chances to get side effects.

### Disadvantages:
- New concept for many developers.
- When we break the implementations of a use case in several smaller functions, dependencies need to be passed around.

## 3. Delegating to higher order functions
While functional interfaces are a great way to abstract a use case, they might not be necessary if the use case is only 
used in the same module it is declared. Higher order functions are a lightweight alternative.

### Advantages:
- Less abstraction and boilerplate.

### Disadvantages:
- Method signatures can be harder to read.

## 4. Too many parameters
Instead of letting the different implementations use `println` directly, we provide them a `Logger` instance. This 
shows a limit of our current architecture : parameters and dependencies are passed around and create a lot of 
boilerplate code.

## 5. The Arrow library and typealiases
In this branch we introduce the arrow library. That gives us a better error handling in each function implementation.
We also uses `typealias` to keep our code readable.

## 6. Partial application
We finally come to the subject of dependency injection. One possible solution in functional programming is called 
partial application.

### Advantages:
- Another new concept for developers.
- Our code doesn't need to pass dependencies around anymore.

### Disadvantages:
- The method signatures become a bit more difficult to understand.

## 7. Context parameters
We reach the final branch where we use this new feature from Kotlin. It's a subtle change but it helps quite a lot for 
ease of reading in our situation.

### Advantages:
- We can extract dependencies from the method signature.

### Disadvantages:
- We need to use the `context` method to propagate dependencies.