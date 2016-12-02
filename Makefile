all: JavaGuiClient.java
	javac JavaGuiClient.java
	javac Turtle.java
	javac JavaServer.java
	javac JavaClient.java
	javac StdDraw.java
	javac StringParser.java

clean:
	rm *.class
