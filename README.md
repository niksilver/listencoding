## List encoding

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

### Sample run

```
C:\...\listencoding> sbt
Java HotSpot(TM) 64-Bit...
[info] Loading project definition from...
[info] Set current project to listencoding...
> console
[info] Starting scala interpreter...
[info]
Welcome to Scala version 2.11.7 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_45).
...

scala> import org.pigsaw.listencoding._
import org.pigsaw.listencoding._

scala> Encoding.make(List(4,4,4,6,7,6,6,6))
res0: Seq[org.pigsaw.listencoding.Encoding] = List((4,3), 6, 7, (6,3))

scala>
```