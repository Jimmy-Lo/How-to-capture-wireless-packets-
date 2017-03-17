function [Value,probability ] = PDF_of_Column(inputData,c)
%The function computes the Probability Density Distribution of a column
%Input: a cell;
%Output: the p.d.f of the column c in the cell.

%% Main function
        probability = num2cell(0);                
        Value = num2cell(0);                                       
        ColumnValue = inputData(:,c);                   

%         %if two or more columns combined are required.
%         ColumnValue1 = inputData(:,1);      
%         ColumnValue2 = inputData(:,2);
%         ColumnValue3 = inputData(:,5);                   
%         ColumnValue4 = inputData(:,6);
% 
%         for i = 1:length(ColumnValue1)
%                c1=num2str(cell2mat(ColumnValue1(i,1)));
%                c2=num2str(cell2mat(ColumnValue2(i,1)));
%                c3=num2str(cell2mat(ColumnValue3(i,1)));
%                c4=num2str(cell2mat(ColumnValue4(i,1)));
%                c5 = strcat(c1,c2);
%                c6 = strcat(c3,c4);
%                ColumnValue{i}= strcat(c5,c6);
%         end
        
        %figure out the probability distribution regarding to the ValueCelllist
        ValueArray = sort(cell2mat(ColumnValue));
        probability(1) = num2cell(1);
        Value(1) = num2cell(ValueArray(1));
        
        %the distribution
        p = 1;
        for i = 2 : length(ValueArray)
            if (ValueArray(i) == ValueArray(i-1))
                probability(p) = num2cell(probability{p} + 1);
            else
                p = p+1;
                Value(p) = num2cell(ValueArray(i));
                probability(p) = num2cell(1);
            end 
        end

        for i = 1:length(Value)
            probability{i} = probability{i}/length(ValueArray);
        end
                
end