.PHONY: build run clean

name = Compilers-Project

CLASSPATH = "antlr-4.13.1-complete.jar;./target"
JAVAC = javac -cp $(CLASSPATH)
ANTLR = java -jar antlr-4.13.1-complete.jar -no-visitor -no-listener
TESTRIG = java -cp $(CLASSPATH) org.antlr.v4.gui.TestRig

build:
	mkdir -p target
	kotlinc -cp $(CLASSPATH) -d target src/backend/*.kt
	$(ANTLR) -o target src/PL.g4
	$(JAVAC) -d target target/*.java

clean:
	rm -rf ./target
	rm -f ./output.ipynb
