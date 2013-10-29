
#include "filestudy.h"
#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int testFile() {
	ofstream outfile("out_file");
	ifstream infile("in_file");

	if (!infile) {
		cerr << "Error, unable open input file" << endl;
		return -1;
	}

	if (!outfile) {
		cerr << "Error, unalbe open output file" << endl;
	}

	return 0;
}
