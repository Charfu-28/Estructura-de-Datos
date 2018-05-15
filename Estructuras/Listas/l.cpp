#include "list.h"
#include <iostream>
#include <string>

using namespace std;

int main() {
	List<string> phrase;
	phrase.append("hakuna");
	phrase.append("matata");
	phrase.print();
	return 0;
}

