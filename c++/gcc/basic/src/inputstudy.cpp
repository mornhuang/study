/*
 * inputstudy.cpp
 *
 *  Created on: 2011-10-12
 *      Author: IBM
 */
#include "inputstudy.h"
#include <iostream>

using namespace std;

void readIn() {
	cout << "readIn()" << endl;
	cout << endl;

	string word;
	while (cin >> word) {
		cout << "word input is" << word << endl;
		cout << endl;
	}

	cout << "end input word" << endl;
}

