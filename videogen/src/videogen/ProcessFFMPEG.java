package videogen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ProcessFFMPEG {
	public static String getDuration(String filepath) throws IOException{
		String aa = "/usr/bin/ffmpeg -i " + filepath + 
				" 2>&1 | grep \"Duration\"| cut -d ' ' -f 4 | sed s/,// | sed 's@\\..*@@g' | awk '{ split($1, A, \":\"); split(A[3], B, \".\"); print 3600*A[1] + 60*A[2] + B[1] }'";
		Process p = Runtime.getRuntime().exec(new String[] {"/bin/sh",
                "-c",
                aa});
		
		BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()) );
		String line = new String();
		String duration = new String();
		while ((line = in.readLine()) != null) {
			duration += line;
		}
		in.close();
		return duration;
	}
	
	public static void generateImage(String filepath) throws IOException{
		String aa = "ffmpeg -y -i " + filepath + " -r 1 -t 00:00:01 -ss 00:00:2 -f image2 " + filepath.split("\\.")[0]  +".png";
		Process p = Runtime.getRuntime().exec(new String[] {"/bin/sh",
                "-c",
                aa});
		
		BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()) );
		String line = new String();
		String duration = new String();
		while ((line = in.readLine()) != null) {
			duration += line;
		}
		in.close();
	}
	public static void generateGIF(List<String> filepaths) throws IOException{
		String aa = "ffmpeg ";

		for(String fp : filepaths) {
			aa = aa + " -i " + fp ;
		}

		aa = aa +" ss 00:00:00.000 -pix_fmt rgb24 -r 10 -s 320x240 -t 00:00:10.000  output.gif";
		Process p = Runtime.getRuntime().exec(new String[] {"/bin/sh",
                "-c",
                aa});
		
		BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()) );
		String line = new String();
		String duration = new String();
		while ((line = in.readLine()) != null) {
			duration += line;
		}
		in.close();
	}
	public static void main(String[] args) throws IOException {
		System.out.println("dur = " + 	getDuration("/home/aroua/IDM2/VideoGen/videogen/V1/v1.mp4"));
	}
}

