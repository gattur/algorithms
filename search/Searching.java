package search;

public class Searching {

	int a[]={1,3,3,5,8,8,8,9,9};
	
	int binarySearch(int a1){
		return binarySearch(0,a.length-1,a1);
	}
	int binarySearch(int low,int high,int finder){
		if(low>high){
			return -1;
		}
		int left=-1;
		int right=-1;
		System.out.println("left right "+low+" "+high);
		int mid=(low+high)/2;
		System.out.println("mid "+mid);
		if(finder==a[mid])
			return mid;
		else if(a[mid]<finder){
		left=binarySearch(mid+1,high,finder);
		if(left!=-1)return left;
		}
			else{
	 right=binarySearch(low,mid-1,finder);
			if(right!=-1)return right;
			}
		return right;
	}

	int multiplier(int num,int times){
		if(times==0)
			return 0;
		
		if(times%2==1)
			return num+multiplier(num,times-1);
		else{
			int sum=multiplier(num, times>>1);
			return sum+sum;
		}
		
	}
	
	//int a[]={1,3,5,8,51,3,2};
	// increasing peak and reducing
	int findPeak(){
		return findPeak(0,a.length-1);
	}
	int findPeak(int min,int max){
		if(min>max)
			return -1;
		int mid=(min+max)/2;
		if(mid==0 | mid==max)
			return a[mid];
		int right=-1;
		if(a[mid-1]<a[mid] && a[mid]>a[mid+1])
			return a[mid];
		else if(a[mid]<a[mid+1] && a[mid]>a[mid-1]){
			int left=findPeak(mid+1,max);
			if(left!=-1)
				return left;
		}
		else{
			right=findPeak(min,max-1);		
		}
		return right;
		
		
		
	}

	// int a[]={1,3,3,5,8,8,8,9,9};
	// starting of first continus
	
	int firsCont(int key){
		return firstCont(0,a.length-1,key);
	}
	int firstCont(int min,int max,int key){
		if(min>max)
			return -1;
		int mid=(min+max)/2;
		if((a[mid]==key && mid==min)|| (a[mid] == key && a[mid-1]<key))
				return mid;
		int left=-1;
		int right=-1;
		if(a[mid]>=key){
				left=firstCont(min,mid-1,key);
				if(left!=-1)
					return left;
		}
				else
				right=firstCont(mid+1,max,key);
			return right;	
	}
	
	
	
	
	int firstOccurence(int[] arr,int key,int low,int high){
		if(low>high)
			return -1;
		else{
			int mid=(low+high)>>1;
			if((arr[mid]==key && mid==high) || (arr[mid]==key && arr[mid+1]>arr[mid]))
				return mid;
			else if(arr[mid]<=key)
				return firstOccurence(arr, key, mid+1,high);
			else
				return firstOccurence(arr, key,low,mid-1);
			}
			
	}	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
