   public class Main{
    static int[] keys =new int[256];
public static void intializationAndGeneratekeys(String key){
    int[]state =new int[256];
    
    for (int i=0; i<256;i++){
        state[i] = i;
        keys[i] =key.charAt(i % key.length());
    }
    int j = 0;
    for (int i=0;i<256;i++) {
        j=(j+state[i] +keys[i]) %256;
        int temp =state[i];
        state[i]=state[j];
        state[j]=temp;
    
}
int i=0,index;
j=0;
for (int x=0;x<256;x++){
    i =(i+1)%256;
    j=(j + state[i])%256;
    int temp = state[i];
    state[i]=state[j];
    state[j]=temp;
    index = (state[i] + state[j]) % 256;
    keys[i] = state[index];
    
}
}
 public static String encryption(String plaintext){
    String cipher ="";
    for (int i=0; i<plaintext.length();i++){
        cipher +=(char) (plaintext.charAt(i) ^keys[i % keys.length]);
    }
    return cipher;
 }
 public static String decryption(String cipherText){
     String decrypt ="";
     for (int i= 0; i<cipherText.length(); i++){
         decrypt += (char) (cipherText.charAt(i) ^ keys[i % keys.length] );
         }
          return decrypt;
 }
   }
 


