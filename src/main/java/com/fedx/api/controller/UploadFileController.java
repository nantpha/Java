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

