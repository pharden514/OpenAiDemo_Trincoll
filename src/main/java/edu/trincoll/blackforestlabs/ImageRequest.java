package edu.trincoll.blackforestlabs;

// Java record for the request JSON structure
public record ImageRequest(String prompt, int width,
                    int height, boolean promptUpsampling,
                    Integer seed, Integer safetyTolerance) {

    public ImageRequest(String prompt, int width, int height)  {
        this(prompt, width, height, false, null, null);
    }

    public ImageRequest(String prompt) {
        this(prompt, 1024, 768, false, null, null);
    }

    // Validate the request parameters
    public ImageRequest {
        if (width < 256 || width > 1440) {
            throw new IllegalArgumentException("Width must be between 256 and 1440");
        }
        if (width % 32 != 0) {
            throw new IllegalArgumentException("Width must be a multiple of 32");
        }
        if (height < 256 || height > 1440) {
            throw new IllegalArgumentException("Height must be between 256 and 1440");
        }
        if (height % 32 != 0) {
            throw new IllegalArgumentException("Height must be a multiple of 32");
        }
        if (safetyTolerance != null && (safetyTolerance < 0 || safetyTolerance > 6)) {
            throw new IllegalArgumentException("Safety tolerance must be between 0 and 6");
        }
    }
}
