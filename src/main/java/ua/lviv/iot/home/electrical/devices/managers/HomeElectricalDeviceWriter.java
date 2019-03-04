package ua.lviv.iot.home.electrical.devices.managers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import ua.lviv.iot.home.electrical.devices.models.HomeElectricalDevice;

public class HomeElectricalDeviceWriter {

    public final void writeToFile(final List<HomeElectricalDevice> homeElectricalDeviceList, final File file) throws IOException {

        try (FileOutputStream fos = new FileOutputStream(file);
                OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
                BufferedWriter bufWriter = new BufferedWriter(osw);) {

            for (int i = 0; i < homeElectricalDeviceList.size(); i++) {

                bufWriter.write(homeElectricalDeviceList.get(i).getHeaders());
                bufWriter.newLine();
                bufWriter.write(homeElectricalDeviceList.get(i).toCSV());
                if (i < homeElectricalDeviceList.size() - 1) {
                    bufWriter.newLine();
                    bufWriter.newLine();
                }
            }
        }
    }
}
