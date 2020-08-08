package lockdown.org.texttospeechconversion;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.speech.tts.TextToSpeech;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
{
    EditText etText;
    Button btnSpeak;
    TextToSpeech tts;
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        etText = findViewById(R.id.etText);
        btnSpeak = findViewById(R.id.btnSpeak);
        tts = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener()
        {
            public void onInit(int status)
            {
                tts.setLanguage(Locale.UK);
            }
        });
        btnSpeak.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String data = etText.getText().toString();
                tts.speak(data,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
}