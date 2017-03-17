function [ ] = ConditionalPDF()
% Find the p.d.f of a third column value given the two specific values of the 
%other two columns. e.g. c is a m x n cell, given a pair of value from the 
%column 1 & 2, we can get the p.d.f of the values of column 3 in cell c 
%by using this function.


%% initialize
inputData = importfile('C:/Wireless-Packets-Analysis/matlab_based_analysis/networkData.txt');

%% Main function
    Conditional_row = 1;    %set a specifi row as the condition
    Conditional_col1 = 1;  %set the conditional columns
    Conditional_col2 = 2;
    Aimed_col = 3;
    
    src = inputData(Conditional_row,Conditional_col1);
    dst = inputData(Conditional_row,Conditional_col2);
    ColList = num2cell(0);                    %initialize for every cicle
    
    %find the packet which has the same dst and src address 
    j = 1;
    for i = 1:length(inputData)                                                       
        if (ismember(inputData(i,Conditional_col1),src) && ismember(inputData(i,Conditional_col2),dst))
                ColList(j) = inputData(i, Aimed_col);
                j = j+1;
        end
    end
      
    [Value, Probability] = PDF_of_Column(ColList);  
    Visualization('ConditionalPDF',Value,Probability);
    
end