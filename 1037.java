// 1037. 

class Solution {
    public boolean isBoomerang(int[][] points) {
        // 세 점이 한 직선 위에 존재하는지를 return
        // Hint1. 면적이 0이 아니면 true, 방정식으로는 풀 수 없을지?
        
        double[] distance = new double[3];
        for(int i=0; i<points.length; i++) {
            distance[i] = Math.sqrt(Math.pow(points[i][0]-points[(i+1)%3][0],2)
                                    +Math.pow(points[i][1]-points[(i+1)%3][1],2));
        }
        
        double s = 1/2*(distance[0]+distance[1]+distance[2]);
        double Scale = s*(s-distance[0])*(s-distance[1])*(s-distance[2]);
        
        if(Scale!=0)
            return true;
        else
            return false;
    }
}
/* 미완성. 내일 마저 풀 것. -210327- */


// 210328

class Solution {
    public boolean isBoomerang(int[][] points) {
        // 세 점이 한 직선 위에 존재하는지를 return
        // Hint1. 면적이 0이 아니면 true, 방정식으로는 풀 수 없을지?
        
        double a = Math.sqrt(Math.pow(points[0][0]-points[1][0],2)
                             + Math.pow(points[0][1]-points[1][1]),2);
        double b = Math.sqrt(Math.pow(points[1][0]-points[2][0],2)
                             + Math.pow(points[1][1]-points[2][1]),2);
        double c = Math.sqrt(Math.pow(points[2][0]-points[0][0],2)
                             + Math.pow(points[2][1]-points[0][1]),2);
        
        double s = (a+b+c)/2;
        double Scale = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        
        if(Scale!=0)
            return true;
        else
            return false;
    }
}
/* 틀림.. */


// 210401
class Solution {
    public boolean isBoomerang(int[][] points) {
        // 기울기를 구해서 풂
        
        if(inclination(points[0],points[1]) == inclination(points[0],points[2]))
            return false;
        else if(inclination(points[0],points[1])==998 || inclination(points[1],points[2])==998 || inclination(points[2],points[0])==998)
            return false;
        else
            return true;
    }
    
    public double inclination(int[] point1, int[] point2) {
        int dx = point2[0] - point1[0];
        int dy = point2[1] - point1[1];
        
        if(point1[0]==point2[0] && point1[1]==point2[1])
            return 998;
        if(dx==0)
            return 999;
        else
            return dy/dx;
    }
}
/* 변수가 너무 많음 */


// 210403
class Solution {
    public boolean isBoomerang(int[][] points) {
        // S!=0 -> true; S==0 -> false
        
        // distance
        double a = Math.sqrt(Math.pow(points[0][0]-points[1][0],2)
                             +Math.pow(points[1][0]-points[1][1],2));
        double b = Math.sqrt(Math.pow(points[1][0]-points[2][0],2)
                             +Math.pow(points[1][1]-points[2][1],2));
        double c = Math.sqrt(Math.pow(points[2][0]-points[0][0],2)
                             +Math.pow(points[2][1]-points[0][1],1));
        
        // squre
        double s = (a+b+c)/2;
        double Square = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        
        int sq = (int) Math.ceil(Square);
        
        if(sq==0)
            return false;
        else
            return true;
    }
}
/* [[0,1][0,1][2,1]]에서 오류남. 확인해봤을 때 0으로 나옴에도 true 반환됨. */
