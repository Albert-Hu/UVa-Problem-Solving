#!/bin/bash

if [ $# -ne 0  ]; then
mkdir $1

touch $1/input.txt

touch $1/output.txt

cat > $1/main.c << C_TEMPLATE
#include <stdio.h>

int main(int argc, char* argv[])
{

	return 0;
}
C_TEMPLATE

cat > $1/Main.java << JAVA_TEMPLATE
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	}
}
JAVA_TEMPLATE

cat > $1/main.py << PYTHON_TEMPLATE
def main():
	pass

if __name__ == '__main__':
	main()

PYTHON_TEMPLATE


fi
