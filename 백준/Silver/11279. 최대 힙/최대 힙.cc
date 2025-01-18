#pragma warning(disable:4996)
#include <iostream>
#include <algorithm>
using namespace std;

template<class T>
void Changeheap(T*& a, const int oldsize, const int newsize)
{
	if (newsize > 0)
	{
		T* temp = new T[newsize];
		int number = min(oldsize, newsize);
		copy(a, a + number, temp);
		delete[] a;
		a = temp;
	}
}

template<class T>
class heap
{
public:
	T* maxheap;
	int heapsize;
	int capacity;

	heap(int thecapacity)
	{
		if (thecapacity > 0)
		{
			capacity = thecapacity;
			heapsize = 0;
			maxheap = new T[capacity + 1];
		}
	}
	~heap() { delete[] maxheap; }
	void push(const T& e)
	{
		if (heapsize == capacity)
		{
			Changeheap(maxheap, capacity, 2 * capacity);
			capacity *= 2;
		}
		int curnode = ++heapsize;
		while (curnode != 1 && maxheap[curnode / 2] < e)
		{
			maxheap[curnode] = maxheap[curnode / 2];
			curnode /= 2;
		}
		maxheap[curnode] = e;
	}
	void pop()
	{
		if (heapsize == 0)
		{
			cout << '0' << '\n';
			return;
		}
		else
		{
			cout << maxheap[1] << '\n';
		}
		T last = maxheap[heapsize--];
		int curnode = 1;
		int child = 2;
		while (child <= heapsize)
		{
			if (child < heapsize && maxheap[child] < maxheap[child + 1])
			{
				child++;
			}
			if (last >= maxheap[child]) break;
			maxheap[curnode] = maxheap[child];
			curnode = child;
			child *= 2;
		}
		maxheap[curnode] = last;
	}
};

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int a = 0;
	cin >> a;
	int* b = new int[a];
	heap<int> heap1(a);
	for (int i = 0; i < a; i++)
	{
		cin >> b[i];
	}
	for (int i = 0; i < a; i++)
	{
		if (b[i] == 0)
		{	
			heap1.pop();
		}
		else
		{
			heap1.push(b[i]);
		}
	}
	return 0;
}
