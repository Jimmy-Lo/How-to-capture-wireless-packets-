function [ outputData ] = rowExtract(inputData,row,col)
%extract all the rows of the cell given the condition.
%in this function, we implemented the extraction given a specific value in
%a column, to find all the rows which has the same value as the given
%number.
    
    Value = inputData(row,col);
    
     j=0;
     for i = 1:length(inputData)                    %read all the packets until the end        
        if(ismember(inputData(i,col),Value))      %for all the packet i which has the same dst.
            outputData{i} = inputData(i);
            j=j+1;
        end
    end
  
    



end

