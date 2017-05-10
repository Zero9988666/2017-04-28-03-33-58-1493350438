public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
    	if(bowlingCode.endsWith("|"))
    		bowlingCode=bowlingCode+"-";
    	String[] sss = bowlingCode.split("\\|");
    	int res=0;
    	sss[sss.length-2]=sss[sss.length-1];
    	char[][] ssscc=new char[sss.length][3];
    	int k=0;
    	for(String s1:sss)
    		ssscc[k++]=s1.toCharArray();
    	for(int i=0;i<sss.length-2;i++){

			if(sss[i].equals("X")){
				if(sss[i+1].equals("X")){
					if(sss[i+2].equals("X")){
						res=res+30;
					}else{
						if(ssscc[i+2][0]=='X')
							res=res+30;
						else if(ssscc[i+2][0]=='-')
							res=res+20;
						else
							res=res+20+ssscc[i+2][0]-'0';
					}
				}else if(sss[i+1].equals("XX")){
					res=res+30;
				}else{
					if(ssscc[i+1][1]=='/'){
						res=res+20;
					}else{
						res=res+10;
						if(ssscc[i+1][0]!='-')
							res=res+ssscc[i+1][0]-'0';
						if(ssscc[i+1][1]!='-')
							res=res+ssscc[i+1][1]-'0';
					}
				}
			}else{
				if(ssscc[i][1]=='/'){
					res=res+10;
					if(sss[i+1].equals("X"))
						res=res+10;
					else{
						if(ssscc[i+1][0]!='-')
							res=res+ssscc[i+1][0]-'0';
					}
				}else{
					if(ssscc[i][0]!='-')
						res=res+ssscc[i][0]-'0';
					if(ssscc[i][1]!='-')
						res=res+ssscc[i][1]-'0';
				}
			}

    	}
    	
        return res;
    }
}
