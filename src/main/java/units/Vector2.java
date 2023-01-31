package units;

public class Vector2 {
        float x,y;

        public Vector2(float x, float y){
            this.x = x;
            this.y = y;
        }
        public boolean isEqual(Vector2 opposite){
            if (opposite.y == y && opposite.x == x) return true;
            return false;
        }

        public float distance(float x, float y) {
            float dx = x - this.x;
            float dy = y - this.y;
            return (float) Math.sqrt(dx * dx + dy * dy);
        }
}
