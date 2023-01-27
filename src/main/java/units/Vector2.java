package units;

public class Vector2 {
        int x,y;

        public Vector2(int x, int y){
            this.x = x;
            this.y = y;
        }
        public boolean isEqual(Vector2 opposite){
            if (opposite.y == y && opposite.x == x) return true;
            return false;
        }
}
