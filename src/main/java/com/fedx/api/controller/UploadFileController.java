package com.fedx.api.controller;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fedx.api.model.APIResponse;
import com.fedx.api.model.UploadFilesRequest;
import com.fedx.api.service.UploadFilesService;

@RestController
@RequestMapping("/uploadfiles")
public class UploadFileController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UploadFileController.class);

	@Autowired
	private UploadFilesService uploadFilesService;

	@PostMapping
	public APIResponse uploadFiles(@Valid UploadFilesRequest uploadFilesRequest, BindingResult result)
			throws IllegalStateException, IOException, ServletException {

		if (result.hasErrors()) {
			String fields = result.getFieldErrors().stream().map(FieldError::getField).collect(Collectors.joining(","));
			return new APIResponse(false, "Validation failed on: " + fields);
		}

		int noOfFiles = Optional.ofNullable(uploadFilesRequest.getUploadFiles()).map(ary -> ary.length).orElse(0);
		LOGGER.info("Uploading {} files for project: {} " + noOfFiles, uploadFilesRequest.getProjectId());

		uploadFilesService.uploadFiles(uploadFilesRequest);

		return new APIResponse(true, "Files are uploaded successfully.");
	}
}

 ExecutorService service=Executors.newSingleThreadExecutor();
        final Future<Object> submit = service.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                HttpEntity<?> httpEntity = new HttpEntity<Object>("Prashanth");
                RestTemplate restTemplate=new RestTemplate();
                URI uri = new URI("http://localhost:8090/api/rest");
                String future =restTemplate.postForObject(uri,httpEntity, String.class);
                return "";
            }
        });
        try {
            submit.get(0, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
        }
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class MonoToStereoConverter {

  public static void main(String[] args) throws Exception {
    // Load the mono audio file into a byte array
    byte[] monoData = loadAudioFile("input.wav");

    // Convert the byte array to a float array
    float[] samples = new float[monoData.length / 4];
    for (int i = 0; i < samples.length; i++) {
      samples[i] = ByteBuffer.wrap(monoData, i * 4, 4).order(ByteOrder.LITTLE_ENDIAN).getFloat();
    }

    // Duplicate the float array to create a stereo signal
    float[] stereoSamples = new float[samples.length * 2];
    for (int i = 0; i < samples.length; i++) {
      stereoSamples[i * 2] = samples[i];
      stereoSamples[i * 2 + 1] = samples[i];
    }

    // Convert the stereo signal back to a byte array
    byte[] stereoData = new byte[stereoSamples.length * 4];
    for (int i = 0; i < stereoSamples.length; i++) {
      byte[] sampleBytes = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(stereoSamples[i]).array();
      System.arraycopy(sampleBytes, 0, stereoData, i * 4, 4);
    }

    // Write the stereo signal to a new audio file
    writeAudioFile("output.wav", stereoData);
  }

  private static byte[] loadAudioFile(String fileName) throws Exception {
    // This method should load the audio file into a byte array and return it
    // You can use a Java input stream to read the file and convert it to a byte array
  }

  private static void writeAudioFile(String fileName, byte[] data) throws Exception {
    // This method should write the audio data to a new audio file
    // You can use a Java output stream to write the data to the file
  }
}


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class MonoToStereoConverter {

  public static void main(String[] args) throws Exception {
    // Load the two mono audio files into separate byte arrays
    byte[] monoData1 = loadAudioFile("input1.wav");
    byte[] monoData2 = loadAudioFile("input2.wav");

    // Convert the byte arrays to float arrays
    float[] samples1 = new float[monoData1.length / 4];
    for (int i = 0; i < samples1.length; i++) {
      samples1[i] = ByteBuffer.wrap(monoData1, i * 4, 4).order(ByteOrder.LITTLE_ENDIAN).getFloat();
    }
    float[] samples2 = new float[monoData2.length / 4];
    for (int i = 0; i < samples2.length; i++) {
      samples2[i] = ByteBuffer.wrap(monoData2, i * 4, 4).order(ByteOrder.LITTLE_ENDIAN).getFloat();
    }

    // Interleave the two float arrays to create a stereo signal
    float[] stereoSamples = new float[samples1.length * 2];
    for (int i = 0; i < samples1.length; i++) {
      stereoSamples[i * 2] = samples1[i];
      stereoSamples[i * 2 + 1] = samples2[i];
    }

    // Convert the stereo signal back to a byte array
    byte[] stereoData = new byte[stereoSamples.length * 4];
    for (int i = 0; i < stereoSamples.length; i++) {
      byte[] sampleBytes = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(stereoSamples[i]).array();
      System.arraycopy(sampleBytes, 0, stereoData, i * 4, 4);
    }

    // Write the stereo signal to a new audio file
    writeAudioFile("output.wav", stereoData);
  }

  private static byte[] loadAudioFile(String fileName) throws Exception {
    // This method should load the

	  
	  import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class MonoToStereoConverter {

  public static void main(String[] args) throws Exception {
    // Load the left channel audio file into a byte array
    byte[] leftData = loadAudioFile("left.wav");

    // Convert the byte array to a float array
    float[] leftSamples = new float[leftData.length / 4];
    for (int i = 0; i < leftSamples.length; i++) {
      leftSamples[i] = ByteBuffer.wrap(leftData, i * 4, 4).order(ByteOrder.LITTLE_ENDIAN).getFloat();
    }

    // Load the right channel audio file into a byte array
    byte[] rightData = loadAudioFile("right.wav");

    // Convert the byte array to a float array
    float[] rightSamples = new float[rightData.length / 4];
    for (int i = 0; i < rightSamples.length; i++) {
      rightSamples[i] = ByteBuffer.wrap(rightData, i * 4, 4).order(ByteOrder.LITTLE_ENDIAN).getFloat();
    }

    // Combine the left and right channels into a single stereo signal
    float[] stereoSamples = new float[leftSamples.length * 2];
    for (int i = 0; i < leftSamples.length; i++) {
      stereoSamples[i * 2] = leftSamples[i];
      stereoSamples[i * 2 + 1] = rightSamples[i];
    }

    // Convert the stereo signal back to a byte array
    byte[] stereoData = new byte[stereoSamples.length * 4];
    for (int i = 0; i < stereoSamples.length; i++) {
      byte[] sampleBytes = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(stereoSamples[i]).array();
      System.arraycopy(sampleBytes, 0, stereoData, i * 4, 4);
    }

    // Write the stereo signal to a new audio file
    writeAudioFile("output.wav", stereoData);
  }

  private static byte[] loadAudioFile(String fileName) throws Exception {
    // This method should load the audio file into a byte array and return it
    // You can use a Java input stream to read the file and convert it to a byte array
  }

  private static void writeAudioFile(String fileName, byte[] data) throws Exception {
    // This method should write the audio data to a new audio file
    // You can use a Java output stream to write the data to the file
  }
}

Create a byte array to hold the left channel data and a separate byte array to hold the right channel data.
Read the left channel data into the left channel byte array and the right channel data into the right channel byte array.
Create a new byte array to hold the combined stereo data. This array should be twice the size of the original channel data arrays.
Iterate through the left and right channel data arrays, interleaving the values into the stereo array. For example, the first value in the left channel array should be placed in the first position of the stereo array, the first value in the right channel array should be placed in the second position of the stereo array, the second value in the left channel array should be placed in the third position of the stereo array, and so on.
When you have finished interleaving the data, you should have a stereo audio file stored in the stereo array.	  
	  
	  
	  
byte[] leftChannel = ...; // left channel data
byte[] rightChannel = ...; // right channel data

int stereoLength = leftChannel.length * 2;
byte[] stereo = new byte[stereoLength];

for (int i = 0; i < leftChannel.length; i++) {
  stereo[i * 2] = leftChannel[i];
  stereo[i * 2 + 1] = rightChannel[i];
}

	  
	  
	  
	  
import java.io.FileInputStream;
import java.io.FileOutputStream;

public void convertToStereo(String leftFile, String rightFile, String stereoFile) throws Exception {
    FileInputStream leftStream = new FileInputStream(leftFile);
    FileInputStream rightStream = new FileInputStream(rightFile);
    FileOutputStream stereoStream = new FileOutputStream(stereoFile);

    // Read the left and right audio channels into byte arrays
    byte[] left = new byte[leftStream.available()];
    byte[] right = new byte[rightStream.available()];
    leftStream.read(left);
    rightStream.read(right);

    // Interleave the left and right audio channels and write to the output file
    byte[] stereo = new byte[left.length * 2];
    for (int i = 0; i < left.length; i++) {
        stereo[i * 2] = left[i];
        stereo[i * 2 + 1] = right[i];
    }
    stereoStream.write(stereo);

    leftStream.close();
    rightStream.close();
    stereoStream.close();
}
	  
	  
	  
	  
	  
	  
	  import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class StereoConverter {
    public static void main(String[] args) throws Exception {
        // Define the audio format for the input and output audio
        AudioFormat format = new AudioFormat(44100, 16, 2, true, true);

        // Load the two mono audio channels into byte arrays
        byte[] leftChannel = loadMonoAudio("left_channel.wav");
        byte[] rightChannel = loadMonoAudio("right_channel.wav");

        // Create an input stream for the left channel
        ByteArrayInputStream leftInputStream = new ByteArrayInputStream(leftChannel);
        AudioInputStream leftAudioStream = new AudioInputStream(leftInputStream, format, leftChannel.length / format.getFrameSize());

        // Create an input stream for the right channel
        ByteArrayInputStream rightInputStream = new ByteArrayInputStream(rightChannel);
        AudioInputStream rightAudioStream = new AudioInputStream(rightInputStream, format, rightChannel.length / format.getFrameSize());

        // Combine the two audio streams into a single stereo stream
        AudioInputStream stereoStream = new AudioInputStream(new SequenceInputStream(leftAudioStream, rightAudioStream), format, leftAudioStream.getFrameLength() + rightAudioStream.getFrameLength());

        // Write the stereo audio stream to a file
        AudioSystem.write(stereoStream, AudioFileFormat.Type.WAVE, new File("stereo.wav"));
    }

    // Loads a mono audio file into a byte array
    public static byte[] loadMonoAudio(String fileName) throws Exception {
        // Load the audio file into an audio stream
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(fileName));

        // Convert the audio stream to a byte array
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int read;
        while ((read = audioStream.read(buffer, 0, buffer.length)) != -1) {
            byteArrayOutputStream.write(buffer, 0, read);
        }
        byte[] audioData = byteArrayOutputStream.toByteArray();

        // Close the streams
        audioStream.close();
        byteArrayOutputStream.close();

        return audioData;
    }
}

	  
	  
	  
	  
	  ***********************************
		  // Read the two mono audio files into byte arrays
byte[] left = readAudioFile("left.wav");
byte[] right = readAudioFile("right.wav");

// Determine the length of the interleaved audio data
int length = left.length + right.length;

// Create a new byte array to hold the interleaved audio data
byte[] stereo = new byte[length];

// Interleave the samples from the two audio streams
for (int i = 0; i < length; i += 2) {
  stereo[i] = left[i / 2];
  stereo[i + 1] = right[i / 2];
}

// Create a new AudioInputStream using the interleaved audio data and the appropriate audio format
AudioFormat format = new AudioFormat(44100, 16, 2, true, false);
AudioInputStream ais = new AudioInputStream(new ByteArrayInputStream(stereo), format, length / format.getFrameSize());
**************************************************
	
	byte[] mono1 = ... // mono audio data, channel 1
byte[] mono2 = ... // mono audio data, channel 2
int numSamples = Math.min(mono1.length, mono2.length);

// create a stereo audio buffer
byte[] stereo = new byte[numSamples * 2];

// interleave the mono audio channels into the stereo buffer
for (int i = 0; i < numSamples; i++) {
  stereo[i * 2] = mono1[i];
  stereo[i * 2 + 1] = mono2[i];
}

	  
	  
	  **************************************************
		  
		  
		  // Assume that leftMono and rightMono are byte arrays containing the mono audio data
int stereoLength = leftMono.length + rightMono.length;
byte[] stereo = new byte[stereoLength];

// Combine the left and right channels into the stereo array
for (int i = 0; i < stereoLength; i += 2) {
  stereo[i] = leftMono[i / 2];
  stereo[i + 1] = rightMono[i / 2];
}

// Use the stereo array to create a new audio file or stream with stereo format

	  
	  
	  ------------------------------
		  
		  
		  import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class MonoToStereoConverter {

    public static void main(String[] args) {
        // Load the mono audio data into two byte arrays
        byte[] leftChannelData = getLeftChannelData();
        byte[] rightChannelData = getRightChannelData();

        // Create a byte array to hold the stereo audio data
        byte[] stereoData = new byte[leftChannelData.length * 2];

        // Iterate through the mono data and copy each sample into the stereo data
        for (int i = 0; i < leftChannelData.length; i++) {
            stereoData[i * 2] = leftChannelData[i];
            stereoData[i * 2 + 1] = rightChannelData[i];
        }

        // Create an audio format object to specify the audio format of the stereo data
        AudioFormat audioFormat = new AudioFormat(44100, 16, 2, true, false);

        // Write the stereo data to a WAV file
        try (AudioInputStream ais = new AudioInputStream(new ByteArrayInputStream(stereoData), audioFormat, stereoData.length / audioFormat.getFrameSize())) {
            AudioSystem.write(ais, AudioFileFormat.Type.WAVE, new File("stereo.wav"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
--------------------***********************************--------------------------------
	
	byte[] leftChannel = ...; // data from left channel
byte[] rightChannel = ...; // data from right channel

int numSamples = Math.min(leftChannel.length, rightChannel.length);
int stereoLength = numSamples * 2;
byte[] stereoData = new byte[stereoLength];

for (int i = 0; i < numSamples; i++) {
  stereoData[2*i] = leftChannel[i];
  stereoData[2*i + 1] = rightChannel[i];
}

	  
	  ----------------------------------***********************************************
		  
		  
		  import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MonoToStereo {
  public static void main(String[] args) {
    // Read the two mono audio files into byte arrays
    byte[] leftChannel = readAudio("left.wav");
    byte[] rightChannel = readAudio("right.wav");

    // Create a new byte array to hold the stereo audio data
    byte[] stereo = new byte[leftChannel.length * 2];

    // Iterate over the elements of the mono arrays, and for each element, add it to the stereo array
    // at the corresponding index and at the index immediately following it
    for (int i = 0; i < leftChannel.length; i++) {
      stereo[i*2] = leftChannel[i];
      stereo[i*2+1] = rightChannel[i];
    }

    // Write the stereo audio data to a new audio file
    writeAudio("stereo.wav", stereo);
  }

  // Reads an audio file into a byte array
  public static byte[] readAudio(String fileName) {
    byte[] audioData = null;
    AudioInputStream audioInputStream = null;
    try {
      File file = new File(fileName);
      audioInputStream = AudioSystem.getAudioInputStream(file);
      int bytesPerFrame = audioInputStream.getFormat().getFrameSize();
      int numBytes = (int) (audioInputStream.getFrameLength() * bytesPerFrame);
      audioData = new byte[numBytes];
      audioInputStream.read(audioData);
    } catch (UnsupportedAudioFileException | IOException e) {
      e.printStackTrace();
    } finally {
      if (audioInputStream != null) {
        try {
          audioInputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return audioData;
  }

  // Writes a byte array to an audio file
  public static void writeAudio(String fileName, byte[] audioData) {
    AudioInputStream audioInputStream = new AudioInputStream(new ByteArrayInputStream(audioData),
        new AudioFormat(44100, 16, 2, true, false), audioData.length / 2);
    File fileOut =
----------------------------------------------------*************************************************-----------------------------
	    
	    
	    import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MonoToStereo {
  public static void main(String[] args) {
    // Read the two mono audio files into byte arrays
    byte[] leftChannel = readAudio("left.wav");
    byte[] rightChannel = readAudio("right.wav");

    // Create a new byte array to hold the stereo audio data
    byte[] stereo = new byte[leftChannel.length * 2];

    // Iterate over the elements of the mono arrays, and for each element, add it to the stereo array
    // at the corresponding index and at the index immediately following it
    for (int i = 0; i < leftChannel.length; i++) {
      stereo[i*2] = leftChannel[i];
      stereo[i*2+1] = rightChannel[i];
    }

    // Write the stereo audio data to a new audio file
    writeAudio("stereo.wav", stereo);
  }

  // Reads an audio file into a byte array
  public static byte[] readAudio(String fileName) {
    byte[] audioData = null;
    AudioInputStream audioInputStream = null;
    try {
      File file = new File(fileName);
      audioInputStream = AudioSystem.getAudioInputStream(file);
      int bytesPerFrame = audioInputStream.getFormat().getFrameSize();
      int numBytes = (int) (audioInputStream.getFrameLength() * bytesPerFrame);
      audioData = new byte[numBytes];
      audioInputStream.read(audioData);
    } catch (UnsupportedAudioFileException | IOException e) {
      e.printStackTrace();
    } finally {
      if (audioInputStream != null) {
        try {
          audioInputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return audioData;
  }

  // Writes a byte array to an audio file
  public static void writeAudio(String fileName, byte[] audioData) {
    AudioInputStream audioInputStream = new AudioInputStream(new ByteArrayInputStream(audioData),
        new AudioFormat(44100, 16, 2, true, false), audioData.length / 2);
    File fileOut =
--------------------------------------------
	    
	    
	    // Assume that mono1 and mono2 are byte arrays containing the samples of the two mono audio streams
byte[] stereo = new byte[mono1.length + mono2.length];

for (int i = 0; i < mono1.length; i++) {
    stereo[i * 2] = mono1[i];
    stereo[i * 2 + 1] = mono2[i];
}

// Write the stereo audio to an output stream
OutputStream out = new FileOutputStream("stereo.raw");
out.write(stereo);
out.close();
-------------------------------******************************-----------------
	
	
	
	
	  
