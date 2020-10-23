/* Name :Nihal Punjani
*  Date: 10.9.20
*  Program Description: Program is a Substitution Ciper with Caesar cipher and a Random Cipher as its subclasses.
*/

//Directives for input/output, string, and vectors
#include <iostream>
#include <string>
#include <vector>


using namespace std;

//Substitution Cipher class
class SubstitutionCipher{
  
    public:
    //Declaring two char arrays;
    char encoder[26];
    char decoder[26];
    //Declaring vector to hold key of substitution cipher, key is needed for instances of same letters
    vector<int> key;
    
    //empty constructor
    SubstitutionCipher(){
        
    }
    
    //Constructor that takes string to input into encoder
    SubstitutionCipher(string input){ 
        //storing size of string
        int size = input.length();
        //declaring char with length of string
        char temp[size];
        //using copy method to store the letters into the char array temp, must declare size of array also
        input.copy(temp, size);
        //calling remove spaces with parameter temp
        removeSpaces(temp);
        //for-loop to store the encoder and decoder array values
        for(int k = 0; k< 26; k++){ 
            //assigning
            this->encoder[k] = (temp[k]);
            this->decoder[k] = (char) (65 + k % 26);
            
        }
        
    }
    
    //method to encrypt, takes in a string as a parameter
    string encrypt(string message){
      //calls the method encode with the parmeters message and encoder
	    return encode(message, encoder);
	}
	
	//method to decrypt encrypted message
	string decrypt(string secret){
       //calls the method decode with the parmeters secret and decoder
	    return decode(secret, decoder);
	}

  //method to encode input string and output encoded message
  string encode(string original, char *code){
        //storing size of string
        int size = original.length();
        //declaring char with length of string
        char temp[size];
        //using copy method to store the letters into the char array temp, must declare size of array also
        original.copy(temp, size);
        //string to store the message
        string cWord = "";
        //for-loop that iterates through array
        for(int k = 0; k < sizeof(temp); k++){
            //if condition to check if letter is uppercase
            if(isupper(temp[k])){ 
                //storing the asii value of the char minus 'A' which is 65
                int j = temp[k] - 'A'; 
                //stores the int value in vector used to decrypt later
                key.push_back(j); 
                //storing char from encoder array into temp array
                temp[k] = code[j];
                //adding the char to the string
                cWord = cWord + temp[k];
            }
            //when input is not an uppercase letter 
            else { 
                //stores the value as a 0 into the vector
                key.push_back(0);
                //adds the char to the string
                cWord = cWord + temp[k];
            }
        }
        //returns the string
        return cWord; //1
    }
    
    
    //method to decryp encrypted string takes in parameter for string and char array
    string decode(string original, char *code){
        //storing size of string
        int size = original.length(); 
        //declaring char with length of string
        char temp[size];  
        //using copy method to store the letters into the char array temp, must declare size of array also
        original.copy(temp, size);
         //string to store the message
        string cWord = "";
        //for-loop that iterates through array
        for(int k = 0; k < sizeof(temp); k++){
            //if condition to check if letter is uppercase
            if(isupper(temp[k])){
                //grabs the int value at k
                int j = key.at(k);
                //reassigns the value of temp[k] with value of code[j]
                temp[k] = code[j];
                //adding the character at temp[k] to the string
                cWord = cWord + temp[k];
            }
            //when input is not an uppercase letter
            else {
                //adds the char to the string
                cWord = cWord + temp[k];
            }
        }
        //returns string
        return cWord;
        
    }
    
   
    //method to remove spaces from char array
    void removeSpaces(char *str)
    { 
    // To keep track of non-space character count 
    int count = 0;
  
    // Traverse the given string. If current character is not space, then place it at index 'count++' 
    for (int i = 0; str[i]; i++)
        if (str[i] != ' ')
            str[count++] = str[i]; 
                                  
    str[count] = '\0';
    } 
    
    //method to output encoder array  
    string getEncoder(){
        string ecode = "";
        //int to store size of encoder
        int size = sizeof(this->encoder);
            //for-loop to go through every iteration of encoder
            for(int i; i < size; i++){
                //outputs each char
                ecode = ecode +this->encoder[i];
            }
            //end line after iteration is done
            return ecode;
    }
    
    //method to output decoder
    string getDecoder(){
        string dcode = "";
        //int to store size of decoder
        int size = sizeof(this->decoder);
            //for-loop to go through every iteration of decoder
            for(int i; i < size; i++){
                //outputs each char
                dcode = dcode +  this->decoder[i];
            }
            //end line after iteration is done
            return dcode;
    }
    
};

//CaesarCipher Class inherits SubstiutionCipher class
class CaesarCipher: public SubstitutionCipher {
    public:

    //empty constructor
    CaesarCipher(){

    }
    
    //constructor which takes an int parameter
    CaesarCipher(int rotation){
        //for-loop to set value of char at each iteration  
        for (int k=0; k<26; k++) {
    //assigns the char to the k place of encoder
    //rotation shifts alphabet n places
		this->encoder[k] = (char) ('A' + (k + rotation) % 26);
    //assigns the char to the k place of decoder
    //equation reshifts the alphabet in opposite direction to map encoder
		this->decoder[k] = (char) ('A' + (k - rotation +26) % 26);
		}
    }
    
    //method to set rotation of cipher
    void setRotation(int rotation){
        //for-loop to set value of char at each iteration 
        for (int k=0; k<26; k++) {
     //assigns the char to the k place of encoder
    //rotation shifts alphabet n places
		this->encoder[k] = (char) ('A' + (k + rotation) % 26);
    //assigns the char to the k place of decoder
    //equation reshifts the alphabet in opposite direction to map encoder
		this->decoder[k] = (char) ('A' + (k - rotation +26) % 26);
		}
    }

    //method to encrypt parameter message
    string encrypt(string message) {
      //calls the transform method with parameter message and encoder array
      //returns the output
	    return transform(message, encoder);
	}
	
  
  //method to decrypt parameter message
	string decrypt(string secret){ 
      //calls the transform method with parameter secret and decoder array
      //returns the output
	    return transform(secret, decoder);
	}


  //method to transform string from    
  string transform(string original, char *code){
        //int variable to store size of string
        int size = original.length();
        //declaring a char with size length
        char msg[size];
        //empty string to store 
        string test = "";
        //copy contents of original into the array msg
        original.copy(msg, original.length());
        for(int k = 0; k < sizeof(msg); k++){ 
            if(isupper(msg[k])){
            int j = msg[k] - 'A';
            msg[k] = code[j];
            test = test + msg[k];
            } 
            else{
                test = test + msg[k];
            }
        }
        //returns test string
        return test;
    }

};


//Random cipher class cipher randomly assigns each letter into array
class RandomCipher: public SubstitutionCipher{ 
    public: 
    //empty constructor for RandomCipher
    RandomCipher(){
        //assigning the vector as a new instance of itself
        this->key = key; 
        for(int k =0; k < 26; k++){
        //rotation is set at random number of 0-65
        int rotation = rand()%65;
        //assigns the char to the k place of encoder
        //rotation shifts alphabet n places
        this->encoder[k] = (char) ('A' + (k + rotation) % 26 );
        //decoder stores alphabet
        this->decoder[k] =  (char) (65 + k % 26);
        }
    }
    
    
    
};


int main()
{
   srand ( time(NULL) );
   string code = "I AM ARNOLD SCHWARZENEGGER YAA";
   SubstitutionCipher cipher = SubstitutionCipher(code);
   cout << cipher.getEncoder() << endl;
   string message = "APPLES AND BANANAS. TACOBELL IS MY FAVOITE FOOD";
   string coded = cipher.encrypt(message);
   string answer = cipher.decrypt(coded);   
   cout << coded << endl;
   cout << answer << endl;
   CaesarCipher cipher2 = CaesarCipher(3); 
   cout << cipher2.getEncoder() << endl
   string message2 = "THE EAGLE IS IN PLAY MEET AT JOE'S. TESTING ALL POSSIBLE OUTCOMES";
   string coded1 = cipher2.encrypt(message2);
   cout << "Secret: " << coded1 << endl;
   string reveal = cipher2.decrypt(coded1);
   cout << "Answer: " << reveal << endl;  
   RandomCipher cipher3 = RandomCipher();
   string three = cipher3.encrypt(message);
   cout << three << endl;
   three = cipher3.decrypt(three);
   cout << three << endl;
   return 0;
} 
