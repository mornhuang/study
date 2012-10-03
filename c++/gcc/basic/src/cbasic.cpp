//============================================================================
// Name        : cbasic.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include "inputstudy.h"
#include "filestudy.h"
#include "point.h"

using namespace std;

int main() {
//	readIn();
//	cout << "!!!Hello World!!!" << endl; // prints !!!Hello World!!!
//	cout << __FILE__ << endl;
//
//	testFile();
//	testPoint();
//
//	int i = -1;
//	const int ic = i;
//	const int *pic = &ic;
////	int *const cpi = &ic;
//	const int *const cpic = &ic;

	int *pi = new int[12];
	std::cout << sizeof(pi) << std::endl;
	std::cout << sizeof(*pi) << std::endl;
	delete []pi;



	return 0;
}

