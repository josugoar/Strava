package es.deusto.ingenieria.sd.strava.server.data.domain;

import java.time.Duration;
import java.util.Date;

public class Challenge {

    private String name;
    private Date startDate;
    private Date endDate;
    private Float distance;
    private Duration time;
    private boolean isCycling;
    private boolean isRunning;

    public boolean checkChallenge() {
        return checkName() && checkStartDate() && checkEndDate() && checkDistance() && checkTime() && checkType();
    }

    public boolean isActive() {
        if (endDate == null) {
            return false;
        }

        return new Date().compareTo(endDate) < 0;
    }

    public boolean checkName() {
        return name != null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean checkStartDate() {
        if (startDate == null) {
            return false;
        }
        if (endDate == null) {
            return false;
        }

        return startDate.compareTo(endDate) <= 0;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean checkEndDate() {
        if (startDate == null) {
            return false;
        }
        if (endDate == null) {
            return false;
        }

        return startDate.compareTo(endDate) >= 0;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean checkDistance() {
        if (distance == null) {
            return false;
        }
        return distance >= 0;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public boolean checkTime() {
        if (time == null) {
            return false;
        }
        return !time.isNegative();
    }

    public Duration getTime() {
        return time;
    }

    public void setTime(Duration time) {
        this.time = time;
    }

    public boolean checkType() {
        return isCycling && !isRunning || !isCycling && isRunning;
    }

    public boolean isCycling() {
        return isCycling;
    }

    public void setCycling(boolean isCycling) {
        this.isCycling = isCycling;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public String toString() {
        return "Challenge [name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + ", distance="
                + distance + ", time=" + time + ", isCycling=" + isCycling + ", isRunning=" + isRunning + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Challenge other = (Challenge) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (startDate == null) {
            if (other.startDate != null)
                return false;
        } else if (!startDate.equals(other.startDate))
            return false;
        if (endDate == null) {
            if (other.endDate != null)
                return false;
        } else if (!endDate.equals(other.endDate))
            return false;
        if (Float.floatToIntBits(distance) != Float.floatToIntBits(other.distance))
            return false;
        if (time == null) {
            if (other.time != null)
                return false;
        } else if (!time.equals(other.time))
            return false;
        if (isCycling != other.isCycling)
            return false;
        if (isRunning != other.isRunning)
            return false;
        return true;
    }

}
