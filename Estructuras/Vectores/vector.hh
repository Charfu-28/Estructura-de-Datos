#include <cassert>
#include <cstdlib>
#include <iostream>

using namespace std;

template <typename T> class Vector {
private:
  int sz;
  int capacity;
  T *storage;
  int numResizes;

public:
  Vector() : sz(0), capacity(4), numResizes(0) {
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
    // int nc = capacity * 2;
    // int nc = capacity + 1;
    // int nc = capacity * 1.8;
    int nc = capacity * 3;
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
  T get(int i) { return storage[i]; }

  int waste() const { return capacity - sz; }
  int resizes() const { return numResizes; }
};
