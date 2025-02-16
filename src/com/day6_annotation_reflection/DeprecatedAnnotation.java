package com.day6_annotation_reflection;
// Legacy API class
class LegacyAPI {

    // Deprecated method
    @Deprecated
    public void oldFeature() {
        System.out.println("Warning: This is an old feature and should not be used.");
    }

    // New recommended method
    public void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}

// DeprecatedAnnotation class to test the implementation
public class DeprecatedAnnotation {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        // This show  deprecation warning
        api.oldFeature();
        // Recommended method
        api.newFeature();
    }
}
