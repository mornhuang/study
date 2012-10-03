/*
 * point.cpp
 *
 *  Created on: 2011-10-13
 *      Author: IBM
 */

#include "point.h"

void testPoint() {
	int *pi = new int(10);
	int *pia = new int[10];

	while (*pi < 10) {
		pia[*pi] = *pi;
		*pi = *pi +1;
	}

	delete pi;
	delete []pia;
}


