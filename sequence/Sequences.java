package sequence;

public class Sequences {

	void printSequence(int []a,int n){
		if(n==0){
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i]);	
			}
			System.out.println();
		return;
		}
		for (int i = 0; i < 2; i++) {
			a[n-1]=i;
			printSequence(a, n-1);	
		}
		
	}
	
// permutations

	void permutations(String pre,String post,int r){
		if(pre.length()==r){
			System.out.println(pre);
			return;
		}
		for(int i=0;i<post.length();i++)
			permutations(pre+post.charAt(i),post.substring(0, i)
					+post.substring(i+1,post.length()),r);
	}
	
// combinations
	
	void combinations(String pre,String post){
		System.out.println(pre);
		if(post.length()==0){
			//System.out.println(pre);
			return;
		}
		for(int i=0;i<post.length();i++)
			combinations(pre+post.charAt(i),post.substring(i+1,post.length()));
	
	}
}


