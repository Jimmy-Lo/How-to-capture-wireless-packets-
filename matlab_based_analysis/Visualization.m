function [ output_args ] = Visualization( fileName, value1, value2 )
% visualize the cell2 with respect to cell1 & write it to a .txt file.

        %% visualize
        figure
        stem(cell2mat(value2),'r*');
        title(fileName);
        xlabel('Value');
        ylabel('Probability');    
        
       %% Output to .txt file
       str = strcat(fileName,'.txt');
        fid = fopen(str,'w'); %output .txt file name
        for i = 1:length(value1)
            fprintf(fid,'%5.0f, %1.5f\n',value1{i}, value2{i});
        end   
        
        fclose(fid);   


end

