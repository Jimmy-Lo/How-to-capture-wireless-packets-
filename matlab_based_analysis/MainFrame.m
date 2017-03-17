function [ output_args ] = MainFrame( input_args )

    inputData = importfile2('C:/Wireless-Packets-Analysis/matlab_based_analysis/raw_data_run1.txt');
    [value,probability] = PDF_of_Column(inputData,4);
    Visualization('Q',value, probability);
    
end

