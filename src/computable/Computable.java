package computable;

public interface Computable <A, V>{
    V compute(A arg) throws Exception;
   default V compute(A arg, long expireTime) throws Exception {
       return compute(arg);
   }
}
