while(c<3000)
     c=c+1;
     for i = 1:length(x(1,:))
        for j = 1:nh
            netj(j) = wih(j,1:end-1)*double(x(:,i))+wih(j,end)*1;
            outj(j) = 1./(1+exp(-1*netj(j)));
        end
        
        for k = 1:no
            netk(k) = who(k,1:end-1)*outj'+who(k,end)*1;
            outk(k) = 1./(1+exp(-1*netk(k)));
            delk(k) = outk(k)*(1-outk(k))*(t(k,i)-outk(k));
        end
         delj(j) = outj(j)*(1-outj(j))*s; 
            s=0;
        end
        for k = 1:no
            for l = 1:nh
                who(k,l)=who(k,l)+.5*delk(k)*outj(l);
            end
            who(k,l+1)=who(k,l+1)+1*delk(k)*1;
        end
        for j = 1:nh
            for ii = 1:ni
                wih(j,ii)=wih(j,ii)+.5*delj(j)*double(x(ii,i));
            end
            wih(j,ii+1)=wih(j,ii+1)+1*delj(j)*1;
        end
    end