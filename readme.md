# A done task for inventale

There is no need in any additional extensions or plugins.

Simply compilable with **javac**:

> `javac` - javac -d compiled ./src/Task/Main.java

To compile a **.jar** file:

> `jar` - jar -cmf manifest.mf task.jar -C compiled .

To open **.jar** file:

> `jar` - java -jar task.jar

Answering on your questions and requests:

1. I managed somehow set up Maven project, but as I am not familiar with that technology only you can say if it was made right.
DY: more or less ok
2. I've deleted the compiled parts of project.
DY: ok, do you how .gitignore file?
3. I've created the class for cashBoxes, but I cannot understand your example with intensities of people.
DY:
>users visit every(give negative number if random):
it was comment from your code - it assumes that users visit a shop every X second. I've put X = 5 seconds

4. I've added two junit tests for an example input and for mine.
DY: What do you think, at the moment your code covers all corner cases? 

5. I probably found and fixed the problem, that was related to the space after input line.
DY: I've added a few questions in test - please look at them as well