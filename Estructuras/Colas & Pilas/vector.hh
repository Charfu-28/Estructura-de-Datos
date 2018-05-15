#include <cassert>
#include <cstdlib>
#include <iostream>
#include <cmath>

using namespace std;

template <typename T> class Vector {
private:
  int sz;
  int capacity;
  T *storage;
  int numResizes;
  int Remove_resizes;
public:
  Vector() : sz(0), capacity(4), numResizes(0), Remove_resizes(0) {
    // Allocates memory for an array of capacity elements.
    storage = new T[capacity];
  }
  
  
  int size() const { return sz; }

  
  
  void moveOneRight(int i) {
    for (int j = sz; j > i; j--)
      storage[j] = storage[j - 1];
  }
 
 
  void resize() {
    numResizes = numResizes + 1;
    //int nc = capacity * 1.5;
	//int nc = capacity * 2;
    //int nc = capacity + 1;
    int nc = capacity * 1.8;
    //int nc = capacity * 3;
    T *ns = new T[nc];
    for (int i = 0; i < sz; i++)
      ns[i] = storage[i];
    delete[] storage;
    storage = ns;
    capacity = nc;
  }
  
  
  
  
  
  void add(int i, const T &x) {
    assert(i >= 0 && i <= sz);
    if (sz == capacity) {
      // array is full
      resize();
    }
   
	 moveOneRight(i);
    storage[i] = x;
    sz = sz + 1;
    
    
  }
  
  // REMOVE NAIVE
  void RemoveWaste (int x)
  {
  	assert (sz>0 && x<sz);  
  
  	
	  for (x; x<sz; x++)
  	{
  		storage [x]= storage [x+1];
  		
	  }
  	sz = sz-1;
  	
  	if ((capacity-sz)*2 >= sz)
  	{
	  T* BR = new T [sz];
  	for (int i=0; i<sz; i++)
  	
  	{
  		BR [i]= storage [i];}
  		delete []storage;
  		storage = BR;
  		capacity = sz;
  		Remove_resizes++;
  		
  	
}
}

int resizes_remove ()const 
{
	return Remove_resizes;
}
  	
  
  
  
// REMOVE NAIVE
  void RemoveNaive (int i)
  
  { 
  
  assert (sz>0 && i<sz);  
  
  	
	  for (i; i<sz; i++)
  	{
  		storage [i]= storage [i+1];
  		
	  }
  	sz = sz-1;
  }
  
T get(int i) { 
  assert(i >= 0 && i < sz);
  return storage[i]; }

  int waste() const { return capacity - sz; }
  int resizes() const { return numResizes; }
  
 void print () {
for (int i=0; i<sz; i++)
{
	
	std::cout << " " << get (i);

std:: cout<< std:: endl;	
}
} 
  
};
