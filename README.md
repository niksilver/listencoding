== List encoding

A Scala version of the problem demonstrated by Dave Thomas in
[his Elixir talk](https://www.youtube.com/watch?v=5hDVftaPQwY?t=12m17s).
Given a list of (possibly repeating) integers, such as:
```
(5, 5, 6, 6, 6, 7, 8, 8, 8, 8, 9)
```
we want to generate an encoding, where a repeated integers are compressed
down to a pair consisting of the integer and its repetition count, like this:
```
((5,2), (6, 3), 7, (8,4), 9)
```

Scala's pattern matching isn't as comprehensive as Elixirs, and its
static typing means we can't trivially interchange 2-Tuples and Ints.
So the result isn't as compact.