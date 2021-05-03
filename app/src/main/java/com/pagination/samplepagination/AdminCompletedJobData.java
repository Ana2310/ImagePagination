package com.pagination.samplepagination;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class AdminCompletedJobData {


    @SerializedName("CompletedJobs")
    public List<CompletedJobs> CompletedJobs;

    public static class CompletedJobs {
        @SerializedName("Jobdetail")
        public String Jobdetail;

        public CompletedJobs(String jobdetail) {
            this.Jobdetail=jobdetail;
        }
    }
}
